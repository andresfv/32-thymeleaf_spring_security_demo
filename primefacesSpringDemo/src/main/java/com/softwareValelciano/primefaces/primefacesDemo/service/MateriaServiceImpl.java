package com.softwareValelciano.primefaces.primefacesDemo.service;

import com.softwareValelciano.primefaces.primefacesDemo.dao.MateriaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwareValelciano.primefaces.primefacesDemo.entity.Materia;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public void save(Materia materia) {
        materiaRepository.save(materia);
    }

    @Override
    public void deleteById(int idMateria) {
        materiaRepository.deleteById(idMateria);
    }

    @Override
    public List<Materia> findCursosActivos(int pageNumber, int pageSize, Map<String, SortMeta> sort, Map<String, FilterMeta> filterBy) {
///Para crear el query de forma generica se puede dividir en 4 partes que serían: select from, where, group by, order by
        StringBuilder selectQuery = new StringBuilder("select ma from Materia ma ");
        StringBuilder whereQuery = new StringBuilder();
        StringBuilder groupByQuery = new StringBuilder();
        StringBuilder orderByQuery = new StringBuilder();

        //ORDENAMIENTO POR DATATABLE
        if (sort != null && sort.size() > 0) {
            orderByQuery = new StringBuilder(ordenarDataTable(sort, orderByQuery));
        }

        //FILTRADO POR DATATABLE
        if (filterBy != null && filterBy.size() > 0) {
            whereQuery = new StringBuilder(filtrarDataTable(filterBy, whereQuery));
        }

        //ARMADO DEL HQL
        if (selectQuery.length() > 0) {
            StringBuilder stringQuery = new StringBuilder();
            stringQuery.append(selectQuery);
            if (whereQuery.length() > 0) {
                stringQuery.append(whereQuery);
            }
            if (groupByQuery.length() > 0) {
                stringQuery.append(groupByQuery);
            }
            if (orderByQuery.length() > 0) {
                stringQuery.append(orderByQuery);
            }


            //EJECUCION DEL HQL
        Query query = entityManager.createQuery(stringQuery.toString());
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
            List<Materia> listaMaterias = query.getResultList();

//        listaMaterias.forEach(materia -> {
//            System.out.println("Nombre materia: " + materia.getNombre());
//        });

            return listaMaterias;
        }
        return null;
    }

    @Override
    public long countCursosActivos(Map<String, FilterMeta> filterBy) {
        ///Para crear el query de forma generica se puede dividir en 4 partes que serían: select from, where, group by, order by
        StringBuilder selectQuery = new StringBuilder("select count(ma.id) from Materia ma ");
        StringBuilder whereQuery = new StringBuilder();
        StringBuilder groupByQuery = new StringBuilder();

        //FILTRADO POR DATATABLE
        if (filterBy != null && filterBy.size() > 0) {
            whereQuery = new StringBuilder(filtrarDataTable(filterBy, whereQuery));
        }

        //ARMADO DEL HQL
        if (selectQuery.length() > 0) {
            StringBuilder stringQuery = new StringBuilder();
            stringQuery.append(selectQuery);
            if (whereQuery.length() > 0) {
                stringQuery.append(whereQuery);
            }
            if (groupByQuery.length() > 0) {
                stringQuery.append(groupByQuery);
            }


            //EJECUCION DEL HQL
        Query query = entityManager.createQuery(stringQuery.toString());
            long countResult = (long) query.getSingleResult();
            return countResult;
        }
        return 0L;
    }

    /**
     * Filtra el dataTable según los valores digitados en el encabezado de las
     * columnas.
     *
     * @param filterBy
     * @param whereQuery
     * @return hql where
     */
    public StringBuilder filtrarDataTable(Map<String, FilterMeta> filterBy, StringBuilder whereQuery) {
//        listaMaterias.stream().filter(x -> x.getNombre().startsWith("C")).forEach(System.out::println);
//        listaMaterias.stream().filter(x -> x.getNombre().startsWith("C")).forEach(x -> System.out.println(x.getNombre()));

            for (FilterMeta filterMeta : filterBy.values()) {
                if (filterMeta.getFilterValue() != null) {
                    if (whereQuery.length() == 0) {
                        whereQuery.append(" where ");
                    } else {
                        whereQuery.append(" and ");
                    }
                    if (filterMeta.getFilterMatchMode().equals(MatchMode.STARTS_WITH)) {
                        whereQuery.append(filterMeta.getFilterField() + " like " + "'%" + filterMeta.getFilterValue().toString() + "%'");
                    } else if (filterMeta.getFilterMatchMode().equals(MatchMode.EXACT)) {
                        whereQuery.append(filterMeta.getFilterField() + " = " + "'" + filterMeta.getFilterValue().toString() + "'");
                    }
                }
            }

        return whereQuery;
    }

    /**
     * Ordena los registros del dataTable según la columna marcada para ordenar.
     *
     * @param listaMaterias
     * @return hql orderBy
     */
    public StringBuilder ordenarDataTable(Map<String, SortMeta> sort, StringBuilder orderByQuery) {
//        listaMaterias.stream().sorted((x, y) -> x.getNombre().compareTo(y.getNombre())).forEach(System.out::println);
//        return listaMaterias.stream().sorted((x, y) -> x.getNombre().compareTo(y.getNombre())).collect(Collectors.toList());

        //Si viene un ordenamiento por columna en el dataTable se limpia el query orderBy dando prioridad al nuevo ordenamiento.
        orderByQuery = new StringBuilder();
        orderByQuery.append("order by ");

        for (SortMeta sortMeta : sort.values()) {
            orderByQuery.append(sortMeta.getSortField());

            if (sortMeta.getSortOrder().equals(SortOrder.ASCENDING)) {
                orderByQuery.append(" ASC");
            } else if (sortMeta.getSortOrder().equals(SortOrder.DESCENDING)) {
                orderByQuery.append(" DESC");
            }
        }
        return orderByQuery;
    }
}