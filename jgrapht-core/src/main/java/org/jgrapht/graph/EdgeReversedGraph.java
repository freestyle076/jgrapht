/*
 * (C) Copyright 2006-2017, by John V Sichi and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
package org.jgrapht.graph;

import java.util.*;

import org.jgrapht.*;

/**
 * Provides an edge-reversed view g' of a directed graph g. The vertex sets for the two graphs are
 * the same, but g' contains an edge (v2, v1) iff g contains an edge (v1, v2). g' is backed by g, so
 * changes to g are reflected in g', and vice versa.
 *
 * <p>
 * This class allows you to use a directed graph algorithm in reverse. For example, suppose you have
 * a directed graph representing a tree, with edges from parent to child, and you want to find all
 * of the parents of a node. To do this, simply create an edge-reversed graph and pass that as input
 * to {@link org.jgrapht.traverse.DepthFirstIterator}.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 *
 * @author John V. Sichi
 * @see AsUndirectedGraph
 */
public class EdgeReversedGraph<V, E>
    extends GraphDelegator<V, E>
    implements DirectedGraph<V, E>
{
    /**
     */
    private static final long serialVersionUID = 9091361782455418631L;

    /**
     * Creates a new EdgeReversedGraph.
     *
     * @param g the base (backing) graph on which the edge-reversed view will be based.
     */
    public EdgeReversedGraph(DirectedGraph<V, E> g)
    {
        super(g);
    }

    /**
     * @see Graph#getEdge(Object, Object)
     */
    @Override
    public E getEdge(V sourceVertex, V targetVertex)
    {
        return super.getEdge(targetVertex, sourceVertex);
    }

    /**
     * @see Graph#getAllEdges(Object, Object)
     */
    @Override
    public Set<E> getAllEdges(V sourceVertex, V targetVertex)
    {
        return super.getAllEdges(targetVertex, sourceVertex);
    }

    /**
     * @see Graph#addEdge(Object, Object)
     */
    @Override
    public E addEdge(V sourceVertex, V targetVertex)
    {
        return super.addEdge(targetVertex, sourceVertex);
    }

    /**
     * @see Graph#addEdge(Object, Object, Object)
     */
    @Override
    public boolean addEdge(V sourceVertex, V targetVertex, E e)
    {
        return super.addEdge(targetVertex, sourceVertex, e);
    }

    /**
     * @see DirectedGraph#inDegreeOf(Object)
     */
    @Override
    public int inDegreeOf(V vertex)
    {
        return super.outDegreeOf(vertex);
    }

    /**
     * @see DirectedGraph#outDegreeOf(Object)
     */
    @Override
    public int outDegreeOf(V vertex)
    {
        return super.inDegreeOf(vertex);
    }

    /**
     * @see DirectedGraph#incomingEdgesOf(Object)
     */
    @Override
    public Set<E> incomingEdgesOf(V vertex)
    {
        return super.outgoingEdgesOf(vertex);
    }

    /**
     * @see DirectedGraph#outgoingEdgesOf(Object)
     */
    @Override
    public Set<E> outgoingEdgesOf(V vertex)
    {
        return super.incomingEdgesOf(vertex);
    }

    /**
     * @see Graph#removeEdge(Object, Object)
     */
    @Override
    public E removeEdge(V sourceVertex, V targetVertex)
    {
        return super.removeEdge(targetVertex, sourceVertex);
    }

    /**
     * @see Graph#getEdgeSource(Object)
     */
    @Override
    public V getEdgeSource(E e)
    {
        return super.getEdgeTarget(e);
    }

    /**
     * @see Graph#getEdgeTarget(Object)
     */
    @Override
    public V getEdgeTarget(E e)
    {
        return super.getEdgeSource(e);
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return toStringFromSets(vertexSet(), edgeSet(), true);
    }
}

// End EdgeReversedGraph.java
