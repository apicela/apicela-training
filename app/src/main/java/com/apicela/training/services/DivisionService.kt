package com.apicela.training.services

import com.apicela.training.models.Division
import com.apicela.training.models.Exercise
import java.util.UUID

class DivisionService(){
    fun createDivision( divisionName: String,
                        image: String) : Division {
        val id = UUID.randomUUID();
        val listOfExercises : List<Exercise> = listOf()
        val division = Division(id, divisionName, listOfExercises, image)
        return division
    }

    fun changeListExercisesOfDivision( divisionID : String,
                                       newList : List<Exercise>){
        val division =

    }


}