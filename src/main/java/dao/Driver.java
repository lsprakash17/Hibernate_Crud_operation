package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.JEHA9j;

public class Driver {
	EntityManagerFactory e = Persistence.createEntityManagerFactory("dev");
	EntityManager m = e.createEntityManager();
	EntityTransaction t = m.getTransaction();
	JEHA9j j = new JEHA9j();

	public void add(String name, byte[] b, String address, long phno) {
		j.setName(name);
		j.setVideo(b);
		j.setAddress(AES.encrypt(address, "17"));
		j.setPhno(phno);
		t.begin();
		m.persist(j);
		t.commit();

	}

	public void update(int id, String newname) {
		JEHA9j a = m.find(JEHA9j.class, id);
		t.begin();
		a.setName(newname);
		t.commit();

	}

	public void remove(int id) {
		JEHA9j b = m.find(JEHA9j.class, id);
		t.begin();
		m.remove(b);
		t.commit();
	}

	public void fetchvid(int id) 
	{
		JEHA9j j = m.find(JEHA9j.class, id);
		System.out.println(j.getId());
		System.out.println(j.getVideo());
		t.begin();
		t.commit();
	}
	public void  fetchall(int id)
	{
		Query q=m.createQuery("select a from hibernate a where a.id=?1");
		q.setParameter(1, id);
         List<JEHA9j> l=q.getResultList();
         for(JEHA9j k:l)
         {
        	 System.out.println(k.getId());
        	 System.out.println(k.getName());
        	 System.out.println(AES.decrypt(k.getAddress(),"17"));
        	 System.out.println(k.getPhno());
        	 System.out.println(k.getItime());
        	 System.out.println(k.getUpdatedtime());
         }
	}
	public void fetchidname()
	{
		Query h=m.createQuery("select a from hibernate a");
         List<JEHA9j> o=h.getResultList();
         for(JEHA9j k:o)
         {
        	 System.out.println(k.getId());
        	 System.out.println(k.getName());
         }
	}
}
