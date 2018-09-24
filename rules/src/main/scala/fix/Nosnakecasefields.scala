package fix

import scalafix.v1._
import scala.meta._

class Nosnakecasefields extends SemanticRule("Nosnakecasefields") {

  override def fix(implicit doc: SemanticDocument): Patch = {
//    println("Tree.syntax: " + doc.tree.syntax)
    println("Tree.structure: " + doc.tree.structure)
//    println("Tree.structureLabeled: " + doc.tree.structureLabeled)

    def renameParams(params: List[Term.Param]): List[Patch] = {
      params.collect {
        case Term.Param(_, name@Name(value), _, _) =>
          Patch.replaceTree(name, value.toLowerCase)
      }
    }


    doc.tree.collect {
      case Defn.Class(_, _, _, Ctor.Primary(_, _, params), _) =>
        params.flatMap(renameParams)
      case Term.Select(_, name@Name(value)) =>
        List(Patch.replaceTree(name, value.toLowerCase))
      case Term.Assign(name@Name(value), _) =>
        List(Patch.replaceTree(name, value.toLowerCase))
//      case Term.Assign(name@Name(value), _) =>
//        Patch.replaceTree(name, value.toLowerCase)
    }
  }.flatten.asPatch
}
