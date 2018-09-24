package fix

object Nosnakecasefields {
  case class CaseClass(bad_field: Int)

  class ClassTest(bad_field: Int) {
    def print(): Unit = println(bad_field)
  }

  case class CaseClass2(bad_field: Int, another_bad_field: String)

  // abstract
}



//val caseClassSelect = CaseClass(1).bad_field
//val caseClassApply = CaseClass(bad_field = 1)
//
//case class CaseClass2(bad_field: Int, another_bad_field: String)
//
//val caseClass2Select = CaseClass2(1, "hi").another_bad_field
//val caseClass2Apply = CaseClass2(bad_field = 1, another_bad_field = "hi")
//
//final case class FinalCaseClass(bad_field: Int)
//
//class Class2(val bad_field: Int, val another_bad_field: String)
//
//val class2Select = new Class2(1, "hi").another_bad_field
//val class2Apply = new Class2(bad_field = 1, another_bad_field = "hi")
//
//class ClassTest(bad_field: Int){
//  def print(): Unit = println(bad_field)
//}