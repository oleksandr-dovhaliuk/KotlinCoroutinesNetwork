package com.oleksandrdovhaliuk.corotinesnetwork.data.network

import com.oleksandrdovhaliuk.corotinesnetwork.data.network.dto.RecipeDto
import com.oleksandrdovhaliuk.corotinesnetwork.data.network.dto.RecipeQueryResponse

interface NetworkHelper {
    suspend fun findRecipe(query: String): RecipeQueryResponse

    suspend fun getRecipeById(id: Int): RecipeDto
}