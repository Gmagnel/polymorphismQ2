/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatestaff;

/**
 *
 * @author GTAN
 */
public abstract class Employee {
   //Example 10.4: Employee.java
  // Employee abstract superclass.
  
  private String firstName;
  private String lastName;
  private String socialSecurityNumber;
 
 // three-argument constructor
 public Employee( String first, String last, String ssn )
 {
firstName = first;
 lastName = last;
 socialSecurityNumber = ssn;
 } // end three-argument Employee constructor

 // set first name
 public void setFirstName( String first )
 {
 firstName = first;
 } // end method setFirstName

// return first name
 public String getFirstName()
 {
 return firstName;
 } // end method getFirstName
 // set last name
 public void setLastName( String last )
{
 lastName = last;
 } // end method setLastName

 // return last name
 public String getLastName()
 {
 return lastName;
 } // end method getLastName
 // set social security number
 public void setSocialSecurityNumber( String ssn )
 {
socialSecurityNumber = ssn; // should validate
} // end method setSocialSecurityNumber

 // return social security number
 public String getSocialSecurityNumber()
 {
 return socialSecurityNumber;
 } // end method getSocialSecurityNumber
 // return String representation of Employee object
 public String toString()
 {
 return String.format( "%s %s\nsocial security number: %s",
 getFirstName(), getLastName(), getSocialSecurityNumber() );
 } // end method toString

 // abstract method overridden by subclasses 
 public abstract double earnings(); // no implementation here
 
 
 // end abstract class Employee
public class SalariedEmployee extends Employee
  {
 private double weeklySalary;
 
  // four-argument constructor
 public SalariedEmployee( String first, String last, String ssn,
 double salary )
 {
 super( first, last, ssn ); // pass to Employee constructor
 setWeeklySalary( salary ); // validate and store salary
 } // end four-argument SalariedEmployee constructor

 // set salary
 public void setWeeklySalary( double salary )
 {
 weeklySalary = salary < ? : salary;
 } // end method setWeeklySalary

 // return salary
 public double getWeeklySalary()
 {
 return weeklySalary;
 } // end method getWeeklySalary

 // calculate earnings; override abstract method earnings in Employee
 public double earnings() 
 { 
  return getWeeklySalary(); 
 } // end method earnings 

 // return String representation of SalariedEmployee object 
 public String toString() 
{ 
  return String.format( "salaried employee: %s\n%s: $%,.2f",
  super.toString(), "weekly salary", getWeeklySalary() );
 } // end method toString 

 } // end class SalariedEmployee
  class HourlyEmployee extends Employee
  {
  private double wage; // wage per hour
  private double hours; // hours worked for week
 
  // five-argument constructor
 public HourlyEmployee( String first, String last, String ssn,
 double hourlyWage, double hoursWorked )
 {
 super( first, last, ssn );
 setWage( hourlyWage ); // validate hourly wage
 setHours( hoursWorked ); // validate hours worked
 } // end five-argument HourlyEmployee constructor
 // set wage
 public void setWage( double hourlyWage )
 {
 wage = ( hourlyWage < ) ? : hourlyWage;
 } // end method setWage

 // return wage
 public double getWage()
 {
 return wage;
 } // end method getWage

 // set hours worked
 public void setHours( double hoursWorked )
 {
 hours = ( ( hoursWorked >= ) && ( hoursWorked <= ) ) ?
 hoursWorked : ;
 } // end method setHours

 // return hours worked
 public double getHours()
 {
 return hours;
 } // end method getHours

 // calculate earnings; override abstract method earnings in Employee
 public double earnings() 
 { 
  if ( getHours() <= 40 ) // no overtime 
  return getWage() * getHours(); 
  else 
  return 40 * getWage() + ( getHours() - 40 ) * getWage()  ;
 } // end method earnings 

 // return String representation of HourlyEmployee object 
 public String toString() 
 { 
  return String.format( "hourly employee: %s\n%s: $%,.2f; %s: %,.2f",
  super.toString(), "hourly wage", getWage(), 
  "hours worked", getHours() ); 
 } 
 } 

//CommissionEmployee class extends Employee.
 
  class CommissionEmployee extends Employee
  {
  private double grossSales; // gross weekly sales
  private double commissionRate; // commission percentage
  // five-argument constructor
public CommissionEmployee( String first, String last, String ssn,
 double sales, double rate )
 {
 super( first, last, ssn );
 setGrossSales( sales );
 setCommissionRate( rate );
 } // end five-argument CommissionEmployee constructor

 // set commission rate
 public void setCommissionRate( double rate ){
 commissionRate = ( rate > && rate <) ? rate: ;
 } // end method setCommissionRate

// return commission rate
 public double getCommissionRate()
 {
 return commissionRate;
 } // end method getCommissionRate
 // set gross sales amount
 public void setGrossSales( double sales )
 {
 grossSales = ( sales < ) ? : sales;
 } // end method setGrossSales

 // return gross sales amount
 public double getGrossSales()
 {
 return grossSales;
 } // end method getGrossSales
 // calculate earnings; override abstract method earnings in Employee
 public double earnings() 
 { 
  return getCommissionRate() * getGrossSales(); 
 } // end method earnings 

 // return String representation of CommissionEmployee object public String toString()  
  return String.format( "%s: %s\n%s: $%,.2f; %s: %.2f", 
  "commission employee", super.toString(), 
  "gross sales", getGrossSales(), 
  "commission rate", getCommissionRate() ); 
 
  }
 
  class BasePlusCommissionEmployee extends CommissionEmployee
  {
  private double baseSalary; // base salary per week
 
  // six-argument constructor
  public BasePlusCommissionEmployee( String first, String last,
 String ssn, double sales, double rate, double salary )
 {
 super( first, last, ssn, sales, rate );
 setBaseSalary( salary ); // validate and store base salary
 } // end six-argument BasePlusCommissionEmployee constructor

 // set base salary
 public void setBaseSalary( double salary )
 {
 baseSalary = (salary <  ? : salary); // non-negative
 } // end method setBaseSalary

 // return base salary
 public double getBaseSalary()
 {
 return baseSalary;
 } // end method getBaseSalary

 // calculate earnings; override method earnings in CommissionEmployee
 public double earnings() 
 { 
  return getBaseSalary() + super.earnings(); 
 } // end method earnings 

 // return String representation of BasePlusCommissionEmployee object
 public String toString() 
 { 
 return String.format( "%s %s; %s: $%,.2f", 
  "base-salaried", super.toString(), 
  "base salary", getBaseSalary() ); 
 } // end method toString 
  // end class BasePlusCommissionEmployee

 
}
}
    
    

