/*
rule = Nosnakecasefields
*/
package fix

object Nosnakecasefields {
  case class CaseClass(BAD_FIELD: Int)

  val caseClassSelect = CaseClass(1).BAD_FIELD
  val caseClassApply = CaseClass(BAD_FIELD = 1)

  case class CaseClass2(BAD_FIELD: Int, ANOTHER_BAD_FIELD: String)

  val caseClass2Select = CaseClass2(1, "hi").ANOTHER_BAD_FIELD
  val caseClass2Apply = CaseClass2(BAD_FIELD = 1, ANOTHER_BAD_FIELD = "hi")

  final case class FinalCaseClass(BAD_FIELD: Int)

  class Class2(val BAD_FIELD: Int, val ANOTHER_BAD_FIELD: String)

  val class2Select = new Class2(1, "hi").ANOTHER_BAD_FIELD
  val class2Apply = new Class2(BAD_FIELD = 1, ANOTHER_BAD_FIELD = "hi")
}
