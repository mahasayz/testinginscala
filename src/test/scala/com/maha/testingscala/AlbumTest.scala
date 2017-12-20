package com.maha.testingscala

import com.maha.testinginscala.Album
import com.maha.testinginscala.Artist
import org.scalatest.FunSpec
import org.scalatest.Matchers
import org.scalatest.Tag

/**
  * Created by mahbubalam on 18.12.17.
  */
class AlbumTest extends FunSpec with Matchers {

  describe("An Album") {
    it ("can add an Artist object to the album") {
      val album = new Album("Thriller", 1981, new Artist("Michael", "Jackson"))

      album.artist.firstName should be ("Michael")
    }
  }

  describe("Some random tests") {
    it ("should have string tests") {
      val string =
        """
          |I fell into a burning ring of fire.
          |I went down, down and the flames went higher
        """.stripMargin

      string should startWith("I fell")
      string should endWith("higher")
      string should not endWith "my favorite friend, the end"
      string should include("down, down")
      string should not include("Great ball of fire")

      string should startWith regex("I.fel+")
      string should startWith regex("h.{4}r")
    }

    it ("should have relational operator tests") {
      val answerToLife = 42
      answerToLife should be < (50)
      answerToLife should not be > (50)
      answerToLife should be <= (50)
    }

    it ("should have floating-point matchers") {
      (0.9 - 0.8) should be (0.1 +- 0.01)
    }

    it ("should have iterable matchers") {
      List() should be ('empty)
      8 :: 7 :: 6 :: Nil should contain (7)
      (1 to 9) should have length (9)
      (20 to 60 by 2) should have size (21)
    }

    it ("should have property matchers") {
      val album = new Album("Blizzard of Ozz", 1980, new Artist("Ozzy", "Osbourne"))
      album should have (
        'title ("Blizzard of Ozz"),
        'year (1980),
        'artist (new Artist("Ozzy", "Osbourne"))
      )
    }

    it ("should ignore this test by tag", Tag("ignore-test")) {
      info("to exclude this test by tag, type in >testOnly com.maha.testinginscala.AlbumTest -- -l \"ignore-test\"")
      info("to only run this test by tag, type in >testOnly com.maha.testinginscala.AlbumTest -- -n \"ignore-test\"")
      pending
    }

  }

}
