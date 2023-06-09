package model;

import exception.InactiveSlotException;
/**
 * Classe Slot
 * Definisce attributi e metodi dello slot
 * @author Marco
 *
 */
public class Slot {
	
	private final int x;
	private final int y;
	private State state;
	private ItemTile itemTile;
	
	/**
	 * Crea uno slot. 
	 * @param x riga nella griglia
	 * @param y colonna nella griglia
	 */
	public Slot(int x,int y)
	{
		if(x<0) {
			throw new IllegalArgumentException("wrong coordinates: x coordinate is less than 0");
		}
		if(y<0) {
			throw new IllegalArgumentException("wrong coordinates: y coordinate is less than 0");
		}
		
		this.x = x;
		this.y = y;
		this.state = State.ACTIVE;
		this.itemTile = null;
	}
	/**
	 * Costruttore Copia
	 * @param slot
	 */
	public Slot(Slot slot)
	{	
		this.x = slot.x;
		this.y = slot.y;
		this.state = slot.state;
		if(slot.isActive() && !slot.isEmpty()){
		this.itemTile = new ItemTile(slot.itemTile);
		}
		else {
			this.itemTile = null;
		}
	}
	/**
	 * Verifica se lo slot è vuoto.
	 * @return vero se lo slot è vuoto
	 */
	public boolean isEmpty()
	{
		if(!this.isActive()) {
			throw new InactiveSlotException("Slot is not Active");
		}
		if(this.itemTile == null){
			return true;
		}
		return false;
	}
	
	/**
	 * Imposta lo stato dello slot.
	 * @param enum State: Active o Inactive
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * Se lo slot è attivo inserisce la tessera.
	 * @param itemTile tessera da inserire all'interno dello slot.
	 */
	public void setItemTile(ItemTile itemTile) {
		if(!this.isActive()) {
			throw new InactiveSlotException("Slot is not Active");
		}
		this.itemTile = itemTile;
	}
	
	/**
	 * Se lo slot è pieno restituisce la tessera in esso contenuta.
	 */
	public ItemTile getItemTile() {
		if(!this.isActive()) {
			throw new InactiveSlotException("Slot is not Active");
		}
		if(this.isEmpty()) {
			throw new NullPointerException("no tile in slot");
		}
		return itemTile;	
	}
	
	/**
	 * Verifica se lo Slot è Attivo.
	 * @return vero se lo slot è attivo
	 */
	public boolean isActive() {
		if(this.state.equals(State.ACTIVE)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Restituisce la riga in cui è posizionato lo slot nella Griglia
	 */
	public int getX() {
		return x;
	}
	
	/**
	 *	Restituisce la colonna in cui è posizionato lo slot nella Griglia 
	 */
	public int getY() {
		return y;
	}
}
