package com.msm.msmtodo.data

import msm

class Datasource {
//    fun loadData(): List<DataNote>{
//        return listOf(
//            DataNote(id = "MSM01", noteDesc = "Vynést odpadkový koš", checkInd = false),
//            DataNote(id = "MSM02", noteDesc = "Vyzvednout děti", checkInd = true),
//            DataNote(id = "MSM03", noteDesc = "Vynést odpadkový koš", checkInd = true),
//            DataNote(id = "MSM04", noteDesc = "Vyzvednout děti", checkInd = false),
//            DataNote(id = "MSM05", noteDesc = "Vynést odpadkový koš", checkInd = false),
//            DataNote(id = "MSM06", noteDesc = "Vyzvednout děti", checkInd = false),
//            DataNote(id = "MSM07", noteDesc = "Vynést odpadkový koš", checkInd = false),
//
//        )
//    }

    fun loadData(): MutableList<msm>{
        return listOf(
            msm(id = 1, name = "Vynést odpadkový koš", description = "anything"),
            msm(id = 1, name = "zamest", description = "something"),
            msm(id = 1, name = "Nakoupit", description = "anything else"),
            msm(id = 1, name = "Vynést odpadkový koš", description = "apply")
        ).toMutableList()
    }
}

/*
fun main(){
    val sourceList = Datasource().loadData()
    print(sourceList)
    sourceList.forEach {
        println("${it.id} chce ${it.noteDesc} a ${if (it.checkInd) "je" else "není"} hotovo")
    }
}
//*/