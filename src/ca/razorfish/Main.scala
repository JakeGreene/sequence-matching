package ca.razorfish

import scala.collection.immutable.Queue

final case object SNil extends Seq[Nothing] {
  override def isEmpty: Boolean = true
  override def length(): Int = 0
  override def head: Nothing = throw new NoSuchElementException("head of empty sequence")
  override def apply(index: Int): Nothing = throw new NoSuchElementException("accessing empty sequence")
  override def tail: Seq[Nothing] = throw new UnsupportedOperationException("tail of empty sequence")
  override def equals(that: Any) = that match {
    case that1: scala.collection.GenSeq[_] => that1.isEmpty
    case _ => false
  }
  override def iterator(): Iterator[Nothing] = Iterator()
}

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
    val s = Queue(1, 2, 3)
    //val s = "A" :+: "B" :+: SNil
    //val s = "A" :+: "B" :+: Queue("C")
    //val s = "A" :+: "B" :+: List("C")
    //val s = "A" :+: "B" :+: Vector("C")
    s match {
      case head :+: tail => println(s"$head then $tail")
      case _ => println("Hmm")
    }
  }
}