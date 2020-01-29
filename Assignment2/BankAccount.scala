package Assignment2

class BankAccount(){
  private var currentBalance: Int = 0

  def this(balance:Int)
  {
    this()
    this.currentBalance=balance
  }

  def getCurrentBalance(): Int ={
    return currentBalance
  }

  def deposit(n:Int){
    println("Previous Balance: "+currentBalance)
    currentBalance += n
    println("Current Balance: "+currentBalance)
  }

  def withdraw(n:Int){
    if(n>currentBalance){
      println("Not Enough Balance. Current Balance: "+currentBalance)
      return
    }
    println("Previous Balance: "+currentBalance)
    currentBalance -= n
    println("Current Balance: "+currentBalance)
  }


}
