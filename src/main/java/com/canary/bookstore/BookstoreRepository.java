package com.canary.bookstore;

import java.util.Date;
import java.util.List;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

@RepositoryRestResource(collectionResourceRel = "bookstore", path = "books")
public interface BookstoreRepository extends MongoRepository<Book, String> {

    //Find by Exact match; will not be used by front-end
    //List<Book> findByTitle(@Param("param") String title);
    //List<Book> findByAuthor(@Param("param") String author);

    //ISBN assumed unique
    Book findByisbn(String isbn);

    //Find by Containing
    Page<Book> findByTitleContaining(@Param("param") String titleContains, Pageable pageable);
    Page<Book> findByAuthorContaining(@Param("param") String authorContains, Pageable pageable);

    //Case-insensitive versions
    Page<Book> findByTitleContainingIgnoreCase(@Param("param") String titleContains, Pageable pageable);
    Page<Book> findByAuthorContainingIgnoreCase(@Param("param") String authorContains, Pageable pageable);

    //Summary
    List<Book> findBySummaryContainingIgnoreCase(@Param("param") String summaryText, Pageable pageable);

    //Custom query
    @Query(value = "{'publishedDate':{ $gte: ?0, $lte: ?1}}")
    Page<Book> findByPublishedDateRange(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate, Pageable pageable);

    //
    @Query(value = "{'title': { $regex: ?0, $options: 'i'} , " +
            "'author': { $regex: ?1, $options: 'i'} }")
    Page<Book> findByTitleAuthor(@Param("title") String titleContains,
                                 @Param("author") String authorContains,
                                 Pageable pageable);

    //Combined query: Title, Author and Price
    @Query(value = "{'title': { $regex: ?0, $options: 'i'} , " +
            "'author': { $regex: ?1, $options: 'i'} , " +
            "'price':{ $lte: ?2} }")
    Page<Book> findByTitleAuthorAndPriceCap(@Param("title") String titleContains,
                                            @Param("author") String authorContains,
                                            float priceCap,
                                            Pageable pageable);



    @Query(value = "{'title': { $regex: ?0, $options: 'i'} , " +
            "'author': { $regex: ?1, $options: 'i'} , " +
            "'subjects':{ $in: ?2} }")
    Page<Book> findByTitleAuthorAndSubjects(@Param("title") String titleContains,
                                            @Param("author") String authorContains,
                                            String[] subjects,
                                            Pageable pageable);

    @Query(value = "{'title': { $regex: ?0, $options: 'i'} , " +
            "'author': { $regex: ?1, $options: 'i'} , " +
            "'subjects':{ $in: ?2}, " +
            "'price':{ $lte: ?3} }")
    Page<Book> findByTitleAuthorSubjectsPriceCap(@Param("title") String titleContains,
                                            @Param("author") String authorContains,
                                            String[] subjects,
                                            float priceCap,
                                            Pageable pageable);

    //
    @Query(value = "{'subjects':{ $in: ?0}}")
    Page<Book> findBySubjects(String[] subjects, Pageable pageable);

    //
    @Query(value = "{'price':{ $lte: ?0}}")
    Page<Book> findByPriceLessThan(float priceCap, Pageable pageable);

    //float parameters do not seem to be supported
    //@Query(value = "{'rating':{ $gte: ?0, $lte: ?1}}")
    //List<Book> findByRatingBetween(float lowerBound, float upperBound);
}
