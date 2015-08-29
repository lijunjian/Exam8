package com.hand.SpringExam_8820;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
@Aspect
public class Logging {
   /** Following is the definition for a pointcut to select
    *  all the methods available. So advice will be called
    *  for all the methods.
    */
   @Pointcut("execution(* com.tutorialspoint.*.*(..))")
   private void selectAll(){}
   /** 
    * This is the method which I would like to execute
    * before a selected method execution.
    */
   @Before("selectAll()")
   public void beforeAdvice(){
      System.out.println("Before Insert Film Data.");
   }
   /** 
    * This is the method which I would like to execute
    * after a selected method execution.
    */
   @After("selectAll()")
   public void afterAdvice(){
      System.out.println("After Insert Film Data.");
   }
}