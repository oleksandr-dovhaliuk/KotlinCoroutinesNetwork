package com.oleksandrdovhaliuk.coroutinesnetwork.data.network

import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.dto.RecipeDto
import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.dto.RecipeQueryResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeApi {

    private companion object {
        const val AUTHORIZATION = "Authorization"
        const val QUERY = "query"
        const val ID = "id"
    }

    @GET("search")
    suspend fun findRecipe(
        @Header(AUTHORIZATION) authToken: String,
        @Query(QUERY) query: String
    ): RecipeQueryResponse

    @GET("get")
    suspend fun getRecipeById(
        @Header(AUTHORIZATION) authToken: String,
        @Query(ID) id: Int
    ): RecipeDto
}