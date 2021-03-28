package com.oleksandrdovhaliuk.coroutinesnetwork.data.network

import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.dto.RecipeDto
import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.dto.RecipeQueryResponse
import com.oleksandrdovhaliuk.coroutinesnetwork.data.preference.PrefHelper

class NetworkManager(
    private val recipeApi: RecipeApi,
    prefManager: PrefHelper
) : NetworkHelper {

    private var authToken: String = prefManager.getAuthToken()

    override suspend fun findRecipe(query: String): RecipeQueryResponse {
        return recipeApi.findRecipe(authToken, query)
    }

    override suspend fun getRecipeById(id: Int): RecipeDto {
        return recipeApi.getRecipeById(authToken, id)
    }
}