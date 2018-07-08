package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class graph {

	private class edge {

		vertex v1; 
		vertex v2;

		public edge(vertex s1, vertex s2) {
			this.v1 = s1;
			this.v2 = s2;

		}

	}

	private class vertex {
		String name;
		HashMap<vertex, edge> ngbr;

		public vertex(String s) {
			name = s;
			ngbr = new HashMap<>();
		}

		@Override
		public boolean equals(Object other) {
			vertex v = (vertex) (other);
			return this.name.equals(v);

		}

		@Override
		public int hashCode() {

			return this.name.hashCode();

		}

	}

	HashMap<String, vertex> vertices;

	public graph() {
		this.vertices = new HashMap<>();
	}

	public int numvertices() {

		return this.vertices.size();
	}

	public void addvertex(String s) {
		if (this.containsvertex(s)) {
			return;
		}
		vertex vtx = new vertex(s);
		vertices.put(s, vtx);

	}

	private boolean containsvertex(String s) {
		return this.vertices.containsKey(s);

	}

	public void removevertex(String s) {
		if (!this.containsvertex(s)) {
			return;
		}
		vertex vtx = this.getvertex(s);

		Set<vertex> nbrvtx = vtx.ngbr.keySet();
		for (vertex ngb : nbrvtx) {
			ngb.ngbr.remove(vtx);
		}
		this.vertices.remove(s);

	}

	private vertex getvertex(String s) {

		return this.vertices.get(s);

	}

	public boolean containsedge(String v1, String v2) {

		vertex vtx1 = this.getvertex(v1);
		vertex vtx2 = this.getvertex(v2);
		if (vtx1 == null || vtx2 == null) {
			return false;
		}
		return vtx1.ngbr.containsKey(vtx2);

	}

	public int numedge() {
		int rv = 0;
		Collection<vertex> allentries = this.vertices.values();
		for (vertex vtx : allentries) {
			rv += 1;
		}
		return rv / 2;
	}

	public void removeedge(String s1, String s2) {
		vertex vtx1 = this.getvertex(s1), vtx2 = this.getvertex(s2);

		if (vtx1 == null || vtx2 == null || !this.containsedge(s1, s2)) {
			return;
		}
		vtx1.ngbr.remove(vtx2);
		vtx2.ngbr.remove(vtx1);

	}

	public void addedge(String s1, String s2) {
		vertex vtx1 = this.getvertex(s1), vtx2 = this.getvertex(s2);

		if (vtx1 == null || vtx2 == null || this.containsedge(s1, s2)) {
			return;
		}
		edge commmonedge = new edge(vtx1, vtx2);
		vtx1.ngbr.put(vtx2, commmonedge);
		vtx2.ngbr.put(vtx1, commmonedge);

	}

	public void dispay() {
		String tp = null;
		Set<Map.Entry<String, vertex>> allentries = this.vertices.entrySet();
		for (Map.Entry<String, vertex> entry : allentries) {
			vertex vtx = entry.getValue();
			tp = vtx.name + " -->";
			Set<vertex> nbr = vtx.ngbr.keySet();
			for (vertex n : nbr) {
				tp += n.name + ",";
			}
			tp += "END";
			System.out.println(tp);
		}

	}

	public boolean haspath(String v1, String v2) {
		vertex ver1 = this.vertices.get(v1);
		vertex ver2 = this.vertices.get(v2);
		if (ver1 == null || ver2 == null) {
			return false;
		}
		/*
		 * HashMap<vertex, vertex> check = new HashMap<>(); check.put(ver1,
		 * ver1); return haspathfromtoDFS(ver1, ver2, check);
		 */
		return haspathfromtoDFSI(ver1, ver2);

	}

	public boolean haspathfromtoDFS(vertex v1, vertex v2, HashMap<vertex, vertex> check) {

		if (v1.ngbr.containsKey(v2)) {
			return true;
		}
		Set<vertex> nbrs = v1.ngbr.keySet();
		for (vertex n : nbrs) {
			if (!check.containsKey(n)) {
				check.put(n, n);
				if (haspathfromtoDFS(n, v2, check)) {
					return true;
				}

			}

		}
		return false;

	}

	public boolean haspathfromtoBFS(vertex v1, vertex v2) {
		LinkedList<vertex> queue = new LinkedList<>();
		HashMap<vertex, vertex> check = new HashMap<>();
		queue.add(v1);
		while (!queue.isEmpty()) {
			vertex v = queue.removeFirst();
			if (v.ngbr.containsKey(v2)) {
				return true;
			}
			Set<vertex> nbrs = v.ngbr.keySet();
			for (vertex n : nbrs) {
				if (!check.containsKey(n)) {
					check.put(n, n);
					queue.addLast(n);
				}

			}

		}

		return false;
	}

	public boolean haspathfromtoDFSI(vertex v1, vertex v2) {
		LinkedList<vertex> stack = new LinkedList<>();
		HashMap<vertex, vertex> check = new HashMap<>();
		stack.add(v1);
		while (!stack.isEmpty()) {
			vertex v = stack.removeFirst();
			if (v.ngbr.containsKey(v2)) {
				return true;
			}
			Set<vertex> nbrs = v.ngbr.keySet();
			for (vertex n : nbrs) {
				if (!check.containsKey(n)) {
					check.put(n, n);
					stack.addFirst(n);
				}

			}

		}

		return false;
	}

	public void bft() {
		HashMap<vertex, vertex> check = new HashMap<>();

		Collection<vertex> coll = this.vertices.values();
		LinkedList<vertex> queue = new LinkedList<>();

		for (vertex ver : coll) {

			if (!check.containsKey(ver)) {
				check.put(ver, ver);
				queue.add(ver);
				while (!queue.isEmpty()) {
					vertex v = queue.removeFirst();
					System.out.println(v.name);

					Set<vertex> nbrs = v.ngbr.keySet();
					for (vertex n : nbrs) {
						if (!check.containsKey(n)) {
							check.put(n, n);
							queue.addLast(n);
						}

					}

				}

			}
		}

	}

	public void dft() {
		HashMap<vertex, vertex> check = new HashMap<>();

		Collection<vertex> coll = this.vertices.values();
		LinkedList<vertex> stack = new LinkedList<>();

		for (vertex ver : coll) {

			if (!check.containsKey(ver)) {
				check.put(ver, ver);
				stack.addFirst(ver);
				while (!stack.isEmpty()) {
					vertex v = stack.removeFirst();
					System.out.println(v.name);

					Set<vertex> nbrs = v.ngbr.keySet();
					for (vertex n : nbrs) {
						if (!check.containsKey(n)) {
							check.put(n, n);
							stack.addFirst(n);
						}

					}

				}

			}
		}

	}

	public boolean isconnected() {
		HashMap<vertex, vertex> check = new HashMap<>();

		vertex[] arrayver = new vertex[this.vertices.size()];

		this.vertices.entrySet().toArray(arrayver);
		vertex ver = arrayver[0];

		LinkedList<vertex> queue = new LinkedList<>();

		check.put(ver, ver);
		queue.add(ver);
		while (!queue.isEmpty()) {
			vertex v = queue.removeFirst();

			Set<vertex> nbrs = v.ngbr.keySet();
			for (vertex n : nbrs) {
				if (!check.containsKey(n)) {
					check.put(n, n);
					queue.addLast(n);
				}

			}

		}

		return this.vertices.size() == check.size();

	}

	public ArrayList<ArrayList<String>> allconnectedcomp() {
		HashMap<vertex, vertex> check = new HashMap<>();
		ArrayList<ArrayList<String>> rv = new ArrayList<>();
		Collection<vertex> coll = this.vertices.values();
		LinkedList<vertex> stack = new LinkedList<>();
		ArrayList<String> inner = null;
		for (vertex ver : coll) {

			if (!check.containsKey(ver)) {
				inner = new ArrayList<>();
				check.put(ver, ver);
				stack.addFirst(ver);

				while (!stack.isEmpty()) {
					vertex v = stack.removeFirst();

					inner.add(v.name);

					Set<vertex> nbrs = v.ngbr.keySet();

					for (vertex n : nbrs) {
						if (!check.containsKey(n)) {
							check.put(n, n);
							stack.addFirst(n);

						}

					}

				}
				rv.add(inner);

			}
		}
		return rv;

	}

	public boolean isbiparted() {
		HashMap<vertex, String> check = new HashMap<>();
		Collection<vertex> coll = this.vertices.values();
		LinkedList<vertex> queue = new LinkedList<>();

		for (vertex ver : coll) {

			if (!check.containsKey(ver)) {

				check.put(ver, "r");
				queue.add(ver);
				while (!queue.isEmpty()) {
					vertex v = queue.removeFirst();

					Set<vertex> nbrs = v.ngbr.keySet();
					String colortocheck = check.get(v);
					for (vertex n : nbrs) {
						if (!check.containsKey(n)) {

							if (colortocheck.equals("r")) {
								check.put(n, "g");
							} else if (colortocheck.equals("g")) {
								check.put(n, "r");
							}

							queue.addLast(n);

						} else {
							String toPut = (colortocheck.equals("r") ? "g" : "r");
							if (!check.get(n).equals(toPut)) {
								return false;
							}

						}

					}

				}

			}
		}
		return true;

	}

	public boolean isacyclic() {
		HashMap<vertex, vertex> check = new HashMap<>();
		Collection<vertex> coll = this.vertices.values();
		LinkedList<vertex> stack = new LinkedList<>();

		for (vertex ver : coll) {

			if (!check.containsKey(ver)) {

				check.put(ver, null);
				stack.addFirst(ver);
				while (!stack.isEmpty()) {
					vertex v = stack.removeFirst();

					Set<vertex> nbrs = v.ngbr.keySet();

					for (vertex n : nbrs) {
						if (!check.containsKey(n)) {

							check.put(n, v);

							stack.addFirst(n);

						} else {
							vertex reasonfver = check.get(v);
							if (reasonfver == n) {
								continue;
							}
							return false;

						}

					}

				}

			}
		}
		return true;

	}

	public boolean istree() {
		return this.isacyclic() && this.isconnected();

	}

}
