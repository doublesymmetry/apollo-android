// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_in_fragment.fragment

import com.apollographql.apollo3.api.Fragment
import com.apollographql.apollo3.api.Operation
import com.apollographql.apollo3.api.ResponseAdapterCache
import com.apollographql.apollo3.api.ResponseField
import com.apollographql.apollo3.api.internal.ResponseAdapter
import com.example.fragment_in_fragment.fragment.adapter.StarshipFragmentImpl_ResponseAdapter
import kotlin.String
import kotlin.collections.List

class StarshipFragmentImpl : Fragment<StarshipFragmentImpl.Data> {
  override fun adapter(customScalarAdapters: ResponseAdapterCache): ResponseAdapter<Data> {
    val adapter = customScalarAdapters.getFragmentAdapter("StarshipFragmentImpl") {
      StarshipFragmentImpl_ResponseAdapter(customScalarAdapters)
    }
    return adapter
  }

  override fun responseFields(): List<ResponseField.FieldSet> = listOf(
    ResponseField.FieldSet(null, StarshipFragmentImpl_ResponseAdapter.RESPONSE_FIELDS)
  )
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  /**
   * A single transport craft that has hyperdrive capability.
   */
  data class Data(
    override val __typename: String = "Starship",
    /**
     * The ID of an object
     */
    override val id: String,
    /**
     * The name of this starship. The common name, such as "Death Star".
     */
    override val name: String?,
    override val pilotConnection: PilotConnection?
  ) : StarshipFragment, Fragment.Data {
    /**
     * A connection to a list of items.
     */
    data class PilotConnection(
      /**
       * A list of edges.
       */
      override val edges: List<Edges?>?
    ) : StarshipFragment.PilotConnection {
      /**
       * An edge in a connection.
       */
      data class Edges(
        /**
         * The item at the end of the edge
         */
        override val node: Node?
      ) : StarshipFragment.PilotConnection.Edges {
        /**
         * An individual person or character within the Star Wars universe.
         */
        interface Node : StarshipFragment.PilotConnection.Edges.Node {
          data class PersonNode(
            override val __typename: String,
            /**
             * The name of this person.
             */
            override val name: String?,
            /**
             * A planet that this person was born on or inhabits.
             */
            override val homeworld: Homeworld?
          ) : StarshipFragment.PilotConnection.Edges.Node,
              StarshipFragment.PilotConnection.Edges.Node.Person, PilotFragment, Node {
            /**
             * A large mass, planet or planetoid in the Star Wars Universe, at the time of
             * 0 ABY.
             */
            interface Homeworld : StarshipFragment.PilotConnection.Edges.Node.Person.Homeworld,
                PilotFragment.Homeworld {
              data class PlanetHomeworld(
                override val __typename: String,
                /**
                 * The name of this planet.
                 */
                override val name: String?
              ) : StarshipFragment.PilotConnection.Edges.Node.Person.Homeworld,
                  StarshipFragment.PilotConnection.Edges.Node.Person.Homeworld.Planet,
                  PlanetFragment, PilotFragment.Homeworld.Planet, PilotFragment.Homeworld, Homeworld

              data class OtherHomeworld(
                override val __typename: String
              ) : StarshipFragment.PilotConnection.Edges.Node.Person.Homeworld,
                  PilotFragment.Homeworld, Homeworld

              companion object {
                fun Homeworld.asPlanetHomeworld(): PlanetHomeworld? = this as? PlanetHomeworld

                fun Homeworld.asPlanetFragment(): PlanetFragment? = this as? PlanetFragment
              }
            }
          }

          data class OtherNode(
            override val __typename: String
          ) : StarshipFragment.PilotConnection.Edges.Node, Node

          companion object {
            fun Node.asPersonNode(): PersonNode? = this as? PersonNode

            fun Node.asPilotFragment(): PilotFragment? = this as? PilotFragment
          }
        }
      }
    }
  }
}