package br.com.unb.keycodex.methods

import br.com.unb.keycodex.map.Group

/*
 * Singleton para abrigar os métodos de manipular uma lista de Groups (Filtragem, Ordenação, entre outros...) e
 * retornar uma lista com os caracteres dos Groups restantes após a manipulação.
 */

object GroupsManipulation {

    fun FilterGroupList(groups: List<Group>, condition: (Group) -> Boolean): List<String> {
        return groups.filter(condition).map{x -> x.characters}
    }

    fun IntersperseGroupLists(groups1: List<Group>, groups2: List<Group>): List<String> {

        val interspersed_list : MutableList<Group> = mutableListOf()

        var iterator = 0

        /*
         * Enquanto ambas as listas tem elementos a serem iterados, os elementos de cada lista são
         * intercalados e colocados na lista interspersed_list. Caso uma das listas seja maior que a
         * outra, os elementos restantes da maior lista serão colocados no final da lista
         * insterpersed_list.
         */

        while(iterator < groups1.size || iterator < groups2.size) {

            if(iterator < groups1.size)
                interspersed_list.add(groups1.get(iterator))

            if(iterator < groups2.size)
                interspersed_list.add(groups2.get(iterator))

            iterator += 1

        }

        return interspersed_list.map{x -> x.characters}

    }


    fun SortGroupList(groups: List<Group>, condition: (Group, Group) -> Boolean): List<String> {

        fun AuxCondition(x: Group, y: Group): Int {
            return when {
                condition(x, y) -> 1
                else -> 0
            }
        }

        return groups.sortedWith(Comparator{x, y -> AuxCondition(x, y)}).map{x -> x.characters}

    }

}