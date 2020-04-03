package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
@Embeddable
public class EmployeeId implements Serializable {
	 
	    
	 
	    @Size(min=2, message="Name should have at least 2 characters.")
		@Column(name="Name")
		private String name;
	    
	    @Column(name = "Day")
	    private String day;
	 
	    public EmployeeId() {
	    }
	 
	    
		public EmployeeId(@Size(min = 2, message = "Name should have at least 2 characters.") String name, String day) {
			super();
			this.name = name;
			this.day = day;
		}


		public String getName() {
			return name;
		}


		public String getDay() {
			return day;
		}


		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof EmployeeId)) return false;
	        EmployeeId that = (EmployeeId) o;
	        return Objects.equals(getName(), that.getName()) &&
	                Objects.equals(getDay(), that.getDay());
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(getName(), getDay());
	    }

	
}
