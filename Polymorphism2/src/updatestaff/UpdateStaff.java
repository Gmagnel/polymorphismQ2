
package updatestaff;


public class UpdateStaff {

    
    public static void main(String[] args) {
        
  //create subclass objects 
 SalariedEmployee salariedEmployee =  new SalariedEmployee( "John", "Smith", "111-11-1111" ); 
 HourlyEmployee hourlyEmployee = new HourlyEmployee( "Karen", "Price", "222-22-2222", 40 );
 CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06 );
BasePlusCommissionEmployee basePlusCommissionEmployee =new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300 ); 

 System.out.println( "Employees processed individually:\n" );

 System.out.printf( "%s\n%s: $%,.2f\n\n",
 salariedEmployee, "earned", salariedEmployee.earnings() );
 System.out.printf( "%s\n%s: $%,.2f\n\n",
 hourlyEmployee, "earned", hourlyEmployee.earnings() );
 System.out.printf( "%s\n%s: $%,.2f\n\n",
 commissionEmployee, "earned", commissionEmployee.earnings() );
 System.out.printf( "%s\n%s: $%,.2f\n\n," + basePlusCommissionEmployee + ",earned," + basePlusCommissionEmployee.earnings());

 // create four-element Employee array
 Employee employees[] = new Employee[ 4 ];

 // initialize array with Employees 
 employees[ 0 ] = salariedEmployee; 
 employees[ 1 ] = hourlyEmployee; 
 employees[ 2 ] = commissionEmployee; 
 employees[ 3 ] = basePlusCommissionEmployee;

 System.out.println( "Employees processed polymorphically:\n" );

 // generically process each element in array employees
 for ( Employee currentEmployee : employees )
 {
     System.out.println( currentEmployee ); // invokes toString

 // determine whether element is a BasePlusCommissionEmployee
 if ( currentEmployee instanceof basePlusCommissionEmployee )
 {
 // downcast Employee reference to
 // BasePlusCommissionEmployee reference
 basePlusCommissionEmployee employee = ( BasePlusCommissionEmployee ) currentEmployee;

 double oldBaseSalary = employee.getBaseSalary();
 employee.setBaseSalary( * oldBaseSalary );
 System.out.printf(
 "new base salary with 10%% increase is: $%,.2f\n",
 employee.getBaseSalary() );
 } // end if

 System.out.printf(
 "earned $%,.2f\n\n", currentEmployee.earnings() );
 } // end for

 // get type name of each object in employees array
 for ( int j = 0; j < employees.length; j++ ) 
  System.out.printf( "Employee %d is a %s\n", j, 
  employees[ j ].getClass().getName() ); 
 } // end main
 } // end class PayrollSystemTest
        
    
    

