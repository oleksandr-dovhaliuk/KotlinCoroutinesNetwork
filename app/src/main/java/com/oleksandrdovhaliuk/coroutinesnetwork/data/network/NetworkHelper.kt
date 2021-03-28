package com.oleksandrdovhaliuk.coroutinesnetwork.data.network

import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.dto.RecipeDto
import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.dto.RecipeQueryResponse

interface NetworkHelper {
    suspend fun findRecipe(query: String): RecipeQueryResponse

    suspend fun getRecipeById(id: Int): RecipeDto
}