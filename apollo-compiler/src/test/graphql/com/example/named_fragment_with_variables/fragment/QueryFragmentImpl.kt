// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_with_variables.fragment

import com.apollographql.apollo.api.Fragment
import kotlin.String
import kotlin.collections.List

data class QueryFragmentImpl(
  override val __typename: String = "Query",
  override val organization: Organization?
) : QueryFragment, Fragment.Data {
  data class Organization(
    override val id: String,
    override val user: List<User>
  ) : QueryFragment.Organization {
    interface User : QueryFragment.Organization.User {
      override val __typename: String

      data class UserUser(
        override val __typename: String,
        override val firstName: String,
        override val lastName: String,
        override val avatar: String
      ) : QueryFragment.Organization.User, QueryFragment.Organization.User.User, UserFragment, User

      data class OtherUser(
        override val __typename: String
      ) : QueryFragment.Organization.User, User
    }
  }
}
