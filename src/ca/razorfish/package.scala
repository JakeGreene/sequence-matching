package ca

package object razorfish {
  implicit class RichSeq[A](self: Seq[A]) {
    def :+:[B >: A](a: B): Seq[B] = {
      a +: self
    }
  }
}