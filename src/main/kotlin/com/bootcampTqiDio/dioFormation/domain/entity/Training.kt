package com.bootcampTqiDio.dioFormation.domain.entity

data class Training(val name: String, var content: List<EducationalContent>, val level: Level) {
    val inscritos = mutableListOf<User>()

    fun matricular(user: User) {
        TODO("Utilize o parâmetro $user para simular uma matrícula (usar a lista de $inscritos).")
    }
}

