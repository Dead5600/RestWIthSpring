package com.pro.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.entity.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	SessionFactory factory;

	@Override
	public boolean addMovie(Movie movie) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(movie);
			tx.commit();
			return true;
		} catch (Exception e) {
			System.out.println("Unable to add Movie");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Movie> getAllMovie() {

		Session session = null;
		List<Movie> list = new ArrayList();

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("From Movie");
			list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			System.out.println("Unable to get Movie list");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public Movie getMovie(int id) {
		Session session = null;

		try {
			session = factory.openSession();
			return session.get(Movie.class, id);
		} catch (Exception e) {
			System.out.println("unable to get Movie details");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteMovie(int id) {
		Session session = null;

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Movie movie = session.get(Movie.class, id);
			session.delete(movie);
			tx.commit();

			return true;
		} catch (Exception e) {
			System.out.println("unable to delete Movie details");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateMovie(int id, Movie movie) {
		Session session = null;

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			String s = "UPDATE Movie SET releaseDate = :releaseDate, name = :name where id = :id";
			Query query = session.createQuery(s);
			query.setParameter("releaseDate", movie.getReleaseDate());
			query.setParameter("name", movie.getName());
			query.setParameter("id", id);
			query.executeUpdate();
			tx.commit();

			return true;
		} catch (Exception e) {
			System.out.println("unable to update Movie details");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
