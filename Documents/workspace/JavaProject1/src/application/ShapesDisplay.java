package application;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
/**
 * This class represents any displayable shape list
 * @author Ryan
 *
 * @param <T> The type of shape that is stored in the shape display
 */
public class ShapesDisplay<T extends Shape> extends GridPane implements ObservableList<T>{

	private ArrayList<T> shape_array;
	private final int num_columns;
	private int num_rows = 1;
	/**
	 * Constructor for the ShapesDisplay initializes the grid pane and the internal shape array
	 * 
	 * @param num_columns The number of columns this display will have
	 */
	public ShapesDisplay(int num_columns)
	{
		super(); 
		shape_array = new ArrayList<T>();
		this.num_columns = num_columns;

	}
	
	/**
	 * Sets the element passed to the index passed
	 * @param index
	 * @param e
	 */
	private void setElementInGridPane(int index, T e)
	{
		if(index < num_columns)
			super.addColumn(index, e);
		else if(index % num_columns == 0 && index / num_columns == num_rows)
		{
			super.addRow(index / num_columns, e);
			num_rows++;
		}
		else 
			super.add(e, index % num_columns, index / num_columns);

	}
	

	/**
	 * Adds the object to the ArrayList and to the GridPane
	 */
	public boolean add(T e) {
		shape_array.add(e); //Adds the element to the arrayList
		int index = shape_array.size() - 1; //Gets the index of the new Shape
		setElementInGridPane(index, e);
		return false;
	}

	@Override
	public void add(int index, T element) {
		shape_array.add(index, element);
		
		
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(T... elements) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addListener(ListChangeListener<? super T> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int from, int to) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeAll(T... elements) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ListChangeListener<? super T> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean retainAll(T... elements) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(T... elements) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Collection<? extends T> col) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
