package com.library.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.library.dto.BookSearchDto;
import com.library.entity.Book;
import com.library.entity.QBook;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class BookRepositoryCustomImpl implements BookRepositoryCustom {
	
	private JPAQueryFactory queryFactory;
	
	public BookRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	@Override
	public Page<Book> getBookPage(BookSearchDto booksearchdto, Pageable pageable) {
		
		List<Book> content = queryFactory
				.selectFrom(QBook.book)
				.where(searchByLike(booksearchdto.getSearchTitle(), booksearchdto.getSearchAuthor()))
				.orderBy(QBook.book.id.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
		
	long total = queryFactory.select(Wildcard.count).from(QBook.book)
			.where(searchByLike(booksearchdto.getSearchTitle(), booksearchdto.getSearchAuthor()))
			.fetchOne();
	
		return new PageImpl<>(content, pageable, total);
	}

	private BooleanExpression titleLike(String searchTitle) {
		return StringUtils.isEmpty(searchTitle) ?
				null : QBook.book.title.like("%" + searchTitle + "%");
	}
	
	private BooleanExpression searchByLike(String searchTitle, String searchAuthor) {
		if(StringUtils.equals("title", searchTitle)) {
			return QBook.book.title.like("%" + searchTitle + "%");
		} else if(StringUtils.equals("author", searchAuthor)) {
			return QBook.book.author.like("%" + searchAuthor + "%");
		}
		return null;
	}
}
