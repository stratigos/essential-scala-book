/**
 * Ch 3.4.5.1
 * Simple case class - define previous Cats class as one-liner.
 */
case class Cats(color: String, food: String)

/**
 * Ch 3.4.5.2
 * Simplify Film and Director from previous exercises with case class.
 */
case class Director(
  val firstName: String,
  val lastName: String,
  val yearOfBirth: Int) {

  def name: String = s"$firstName $lastName"
}

object Director {
  def older(director1: Director, director2: Director): Director =
    if (director1.yearOfBirth < director2.yearOfBirth)
      director1
    else
      director2
}

case class Film(
  val name: String,
  val yearOfRelease: Int,
  val imdbRating: Double,
  val director: Director) {

  def directorsAge = director.yearOfBirth - yearOfRelease

  def isDirectedBy(director: Director) = this.director == director
}

object Film {
  def newer(film1: Film, film2: Film): Film =
    if (film1.yearOfRelease < film2.yearOfRelease) film1 else film2

  def highestRating(film1: Film, film2: Film): Double = {
    val rating1 = film1.imdbRating
    val rating2 = film2.imdbRating
    if (rating1 > rating2) rating1 else rating2
  }

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director = {
    if (film1.directorsAge > film2.directorsAge)
      film1.director
    else
      film2.director
  }
}