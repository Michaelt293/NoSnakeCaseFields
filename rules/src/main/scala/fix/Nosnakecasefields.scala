package fix

import scalafix.v1._
import scala.meta._

class Nosnakecasefields extends SemanticRule("Nosnakecasefields") {

  override def fix(implicit doc: SemanticDocument): Patch = {

    def renameParams(params: List[Term.Param]): List[Patch] = {
      params.collect {
        case Term.Param(_, name@Name(value), _, _) =>
          Patch.replaceTree(name, value.toLowerCase)
      }
    }

    doc.tree.collect {
      case Defn.Class(_, _, _, Ctor.Primary(_, _, params), _) =>
        params.flatMap(renameParams).asPatch
      case Term.Select(_, name@Name(value)) =>
        Patch.replaceTree(name, value.toLowerCase)
      case Term.Assign(name@Name(value), _) =>
        Patch.replaceTree(name, value.toLowerCase)
    }
  }.asPatch
}
