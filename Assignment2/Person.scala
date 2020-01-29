package Assignment2

class Person(firstName:String, lastName:String, country:String) {

  var taxTopay: Double = 0;
  var salary: Double = 0

  def this(firstName:String, lastName:String, country:String,taxToPay:Double,salary:Double){
    this(firstName,lastName,country)
    this.taxTopay = taxToPay
    this.salary = salary
  }

  def getSalary():Double = {return salary}
  def setSalary(n:Double)={this.salary = n}

  def getCountry(): String ={
    return country
  }

  def getName(): String ={
    return firstName+" "+lastName
  }
  def getFirstName(): String ={
  return firstName
  }
  def getLastName():String ={
    return lastName
  }

  def getTaxToPay():Double = {
    return taxTopay
  }

  def getInfo()
  {
    println(firstName+" "+lastName+"  belongs to "+country);
  }
}
