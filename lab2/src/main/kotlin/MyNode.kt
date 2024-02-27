import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.model.Factory.graph
import guru.nidi.graphviz.model.Factory.node
import guru.nidi.graphviz.model.Graph
import guru.nidi.graphviz.model.Link
import guru.nidi.graphviz.model.Node
import java.io.File

class MyNode(private val value: String, private val nodes: ArrayList<MyNode> = ArrayList()) {

    var parent: MyNode? = null
    private var graph: Graph? = null

    fun addChild(curNode: MyNode) {
        curNode.parent = this
        nodes.add(curNode)
    }

    override fun toString(): String {
        return value
    }

    fun plot(path: String = "graphs/example.png") {
        if (graph == null) {
            this.graph = toGraph()
        }
        Graphviz.fromGraph(graph!!).render(Format.PNG).toFile(File(path))
    }


    private fun toGraph(): Graph {
        return graph("graph").directed().with(*toGraphNodes(1))
    }

    private fun toGraphNodes(level: Int, parentId: String? = null): Array<Node> {
        val result = ArrayList<Node>()
        val nodeId = value + level + (parentId ?: "")
        val currentNode = node(nodeId).with("label", value)
        result.add(currentNode)

        if (parentId != null) {
            result.add(node(parentId).link(Link.to(currentNode)))
        }

        for (childNode in nodes) {
            result.addAll(childNode.toGraphNodes(level + 1, nodeId))
        }

        return result.toTypedArray()
    }

}