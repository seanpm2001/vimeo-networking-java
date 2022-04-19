package com.vimeo.networking2.params

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.vimeo.networking2.PermissionPolicy
import com.vimeo.networking2.TeamEntity
import com.vimeo.networking2.enums.TeamEntityType
import com.vimeo.networking2.type

/**
 * Body for the request which either newly adds or replaces a TeamPermission for a [TeamEntity].
 *
 * @property permissionPolicyUri the uri of a specific [PermissionPolicy]
 * @property teamEntityType the type of a [TeamEntity]
 * @property teamEntityUri the uri of a specific [TeamEntity]
 */
@JsonClass(generateAdapter = true)
data class ReplaceTeamPermissionParams(
    @Json(name = "permission_policy_uri")
    val permissionPolicyUri: String? = null,

    @Json(name = "team_entity_type")
    val teamEntityType: TeamEntityType? = null,

    @Json(name = "team_entity_uri")
    val teamEntityUri: String? = null
) {
    companion object {
        /**
         * Convenience method which parses entities for relevant params.
         *
         * @param permissionPolicy the permission policy we want to newly associate with a [teamEntity]
         * @param teamEntity the entity we want to parse for purposes of deleting some permission policy association
         * @return am instance of [DeleteTeamPermissionParams] as constructed from a [teamEntity]
         */
        fun fromEntities(permissionPolicy: PermissionPolicy, teamEntity: TeamEntity) = ReplaceTeamPermissionParams(
            permissionPolicyUri = permissionPolicy.uri,
            teamEntityType = teamEntity.type,
            teamEntityUri = teamEntity.uri
        )
    }
}
