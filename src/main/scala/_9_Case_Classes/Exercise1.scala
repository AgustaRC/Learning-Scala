package _9_Case_Classes

object Exercise1 {

  def main(args: Array[String]): Unit = {
    val frankenstein = Book("978-0486282114")
    println(frankenstein)

    val v = Var("x")
    val op = BinOp("+", Number(1), v)

    println(v.name)
    println(op.left)
    println(op.right == Var("x"))

    println(op)
    op.copy(operator = "-")
    println(op)
  }

  case class Book(isbn: String)

  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
}
