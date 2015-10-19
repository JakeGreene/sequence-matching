package ca.razorfish

import scala.collection.immutable.Queue

object :+: {
  def unapply[A](s: Seq[A]): Option[(A, Seq[A])] = s match {
    case s if s.isEmpty => None
    case Seq(head, tail @ _*) => Some(head, tail)
  }
}

final case class :+:[A](override val head: A, private var tl: Seq[A]) extends Seq[A] {
  override def tail: Seq[A] = tl
  override def apply(index: Int): A = {
    if (index == 0) head
    else tl(index - 1)
  }
  override def length(): Int = tl.length + 1
  override def iterator(): Iterator[A] = (head +: tl).iterator
  override def equals(that: Any): Boolean = {
    that match {
      case other: scala.collection.GenSeq[_] => other.equals(head +: tl)
      case _ => false
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    //val s = "A" :+: "B" :+: Queue("C")
    //val s = "A" :+: "B" :+: List("C")
    //val s = "A" :+: "B" :+: Vector("C")
    
    printHeadThenTail("A" :+: "B" :+: Nil) // Normal building but with a twist
    printHeadThenTail("A" :+: Vector("B")) // Build with a sub-type of Seq
    printHeadThenTail(Queue(1, 2, 3))
  }
  
  def printHeadThenTail[T](s: Seq[T]): Unit = {
    println(s"Matching $s with :+:")
    s match {
      case head :+: tail => println(s"$head then $tail")
      case _ => println("Hmm. Nothing here")
    }
  }
}