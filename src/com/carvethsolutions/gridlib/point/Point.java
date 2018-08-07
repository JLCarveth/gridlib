package com.carvethsolutions.gridlib.point;

import java.util.ArrayList;

/**
 * Class that represents a point on a two-dimensional plane.
 * @author John on 5/8/2018
 * @project gridlib
 */
public class Point {

    /**
     * Where the point is located
     */
    private int x,y;

    /**
     * Collection of points connected to this point
     */
    private ArrayList<Point> connected;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

        connected = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get all points connected to this one
     * @return an ArrayList of all points with a connection to this point.
     */
    @SuppressWarnings("WeakerAccess") // What a stupid warning.. Why would a getter be private...
    public ArrayList<Point> getConnected() {
        return connected;
    }

    /**
     * Connects a point to this point. The same point can not be connected twice, though each point can point to each other.
     * @param p the point with which to form a connection
     * @return true if the connection was made
     */
    public boolean addConnection(Point p) {
        if (!connected.contains(p)) {
            connected.add(p);
            return true;
        } else return false;
    }

    /**
     * Removes this point's connection to the given point
     * @param p the point to remove from this points connections
     */
    public void removeConnection(Point p) {
        connected.remove(p);
    }

    /**
     * Removes all connections from this point
     */
    public void removeAllConnections() {
        connected.clear();
    }

    /**
     * Returns true if the two points are connected
     * @param p the point to check for a connection
     */
    public boolean isConnectedTo(Point p) {
        return p.getConnected().contains(this)
                || this.getConnected().contains(p);
    }

    /**
     * If the point has no connections.
     * @return true if the point has no connections
     */
    public boolean isIsolated() {
        return connected.isEmpty();
    }
}
