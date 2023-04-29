package dto;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name="hibernate")
public class JEHA9j {
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
	 private int id;
		@Column(nullable = false)
		private String Name;
		@Column(nullable = false)
		@Lob
		private byte [] video;
		@Column(nullable = false)
		private String address;
		@Column(nullable = false,unique = true)
		private long phno;
		@Version
		Integer  count;
		@CreationTimestamp
		Timestamp itime;
		@UpdateTimestamp
		Timestamp updatedtime;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public byte[] getVideo() {
			return video;
		}
		public void setVideo(byte[] video) {
			this.video = video;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getPhno() {
			return phno;
		}
		public void setPhno(long phno) {
			this.phno = phno;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public Timestamp getItime() {
			return itime;
		}
		public void setItime(Timestamp itime) {
			this.itime = itime;
		}
		public Timestamp getUpdatedtime() {
			return updatedtime;
		}
		public void setUpdatedtime(Timestamp updatedtime) {
			this.updatedtime = updatedtime;
		}
	}

