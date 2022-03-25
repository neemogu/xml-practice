package ru.fit.nsu.np.openmap.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ru.fit.nsu.np.openmap.dao.OsmPersistentEntity;
import ru.fit.nsu.np.openmap.repository.EntityRepository;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseService<T extends OsmPersistentEntity, R extends EntityRepository<T>> {

    @Getter
    protected final R repository;

    @Transactional(readOnly = true)
    public T findOne(Long id) {
        return id == null ? null : repository.findById(id).orElse(null);
    }

    @Transactional
    public List<T> save(Iterable<T> entities) {
        return repository.saveAll(entities);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<T> findAll(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public long count() {
        return repository.count();
    }

    @Transactional
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }
}
