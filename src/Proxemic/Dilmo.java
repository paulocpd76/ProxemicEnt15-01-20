package Proxemic;

import java.util.ArrayList;

/**
 * This class offers the possibility of identifying  the Proxemic Zone of all entities or identities,
 *  which will interact in the Proxemic Environment. It is a useful class for developing Proxemic Environment.
 *  @author pperez003
 *
 */
public class Dilmo {
	private ProxZone proxZone;
	private String zoneEg;
	
	public Dilmo(ProxZone proxZone) {
	this.proxZone=proxZone;
	}
	/**
	 * This method allows to assign a proxemic to an identifiable entity or identity based on the distance D.
	 * @param entity identifiable
	 * @param distance
	 */
 public void setProxemicDI(String entity, double distance) {	
	 if (this.proxZone.getEntities().size()==0) {this.setIniEnty(entity, distance);
	  }
	 else {
		if (entity.equals(this.proxZone.getEntities().get(0).getIdenEntityName())) {
			//System.out.println("update");
			this.proxZone.getEntities().get(0).getRelOfDis().setDistance(distance);
			
		}
		else {
	       this.setIniEnty(entity, distance);
		   for (int i=1; i<this.proxZone.getEntities().size();i++ ) {
		  	if (this.proxZone.getEntities().get(i).getIdenEntityName()==entity) {
			   this.proxZone.getEntities().get(i).getRelOfDis().setDistance(distance);					
			}
		  }
		}
	}
	 
	}
 /**
  * This method returns the proxemic Zone of an identifiable  entity identifiable
  * @param entity name
  * @return
  */
 public String getProxemicDI(String entity) {
	 for (int i=0; i<this.proxZone.getEntities().size(); i++) 
	 {
	  if(entity==this.proxZone.getEntities().get(i).getIdenEntityName()) {
	  	  double ds=this.proxZone.getEntities().get(i).getRelOfDis().getDistance();
		  //System.out.println(this.proxZone.setDistanceofEntity(ds));
	  	  return this.proxZone.setDistanceofEntity(ds);
	 }
	 }
	 return null;
 }
 
 public void setProxemicDIL(String entity,double distance,float location) {
	 
		if (this.proxZone.getEntities().size()==0) {this.setIniEntyDILMO(entity, distance, location);}
		else {
				
			if (entity.equals(this.proxZone.getEntities().get(0).getIdenEntityName())) {
				//System.out.println("update");
				this.proxZone.getEntities().get(0).getRelOfLoc().setRelativeLocationScreen(location);
				this.proxZone.getEntities().get(0).getRelOfDis().setDistance(distance);	
			}
			else {
				 Entity Ed0= new Entity(entity);
				 Distance d= new Distance();
				 Location lo = new Location();
				 Ed0.setRelOfDis(d);
				 Ed0.distance.setDistance(distance);
				 Ed0.setRelOfLocation(lo);
				 Ed0.location.setRelativeLocationScreen(location);
				 this.proxZone.getEntities().add(Ed0);
					
			
			for (int i=1; i<this.proxZone.getEntities().size();i++ ) {
					if (this.proxZone.getEntities().get(i).getIdenEntityName()==entity) {
						this.proxZone.getEntities().get(i).getRelOfLoc().setRelativeLocationScreen(location);
						this.proxZone.getEntities().get(i).getRelOfDis().setDistance(distance);					
						//System.out.println(this.proxZone.getEntities().get(i).getIdenEntityName());
					}
				}
					
				}
		}
 }
 
 public String getProxemicDIL(String entity) {
	 for (int i=0; i<this.proxZone.getEntities().size(); i++) 
	 {
	  if(entity==this.proxZone.getEntities().get(i).getIdenEntityName()) {
	  	  double ds=this.proxZone.getEntities().get(i).getRelOfDis().getDistance();
	  	  String loc=			this.proxZone.getEntities().get(i).getRelOfLoc().getRelativeLocationOnScree();
	  	  //System.out.println(this.proxZone.setDistanceofEntity(ds));
	  	  return this.proxZone.setDistanceofEntity(ds)+"-"+loc;
	 }
	 }
	 return null;
 }
 
 public void setProxemicDIM (String entity,double distance,String axe,float max,float min,float value ) {
	 if (this.proxZone.getEntities().size()==0) {this.setDIM(entity, distance, axe, max, min, value);}
	 else {
		 if (entity.equals(this.proxZone.getEntities().get(0).getIdenEntityName())) {
				//System.out.println("update");
				 switch (axe) {
				 case "azimuth":this.proxZone.getEntities().get(0).getRelOfDisMov().setAzimuthWithRange(max, min, value);break;
				 case "pitch":this.proxZone.getEntities().get(0).getRelOfDisMov().setPitchWithRange(max,min,value);break;
				 case "roll":this.proxZone.getEntities().get(0).getRelOfDisMov().setRollWithRange(max,min,value);break;
				default:break;
			      }
			this.proxZone.getEntities().get(0).getRelOfDis().setDistance(distance);	
				
			 }
		
	   else {
			 Entity Ed0= new Entity(entity);
			 Distance d= new Distance();
			 Movement mo = new Movement();
			 Ed0.setRelOfDis(d);
			 Ed0.distance.setDistance(distance);
			 Ed0.setRelOfDisMov(mo);
			 //Ed0.location.setRelativeLocationScreen(location);
			  switch (axe) {
				 case "azimuth":Ed0.movement.setAzimuthWithRange(max,min, value);break;
				 case "pitch":Ed0.movement.setPitchWithRange(max,min, value);break;
				 case "roll":Ed0.movement.setRollWithRange(max,min, value);break;
				default:break;
			 }
			 this.proxZone.getEntities().add(Ed0);
		   			   
			for (int i=1; i<this.proxZone.getEntities().size();i++ ) {
				if (this.proxZone.getEntities().get(i).getIdenEntityName()==entity) {
					 switch (axe) {
					 case "azimuth":this.proxZone.getEntities().get(i).getRelOfDisMov().setAzimuthWithRange(max, min, value);break;
					 case "pitch":this.proxZone.getEntities().get(i).getRelOfDisMov().setPitchWithRange(max,min,value);break;
					 case "roll":this.proxZone.getEntities().get(i).getRelOfDisMov().setRollWithRange(max,min,value);break;
					default:break;
				 }
					this.proxZone.getEntities().get(i).getRelOfDis().setDistance(distance);					
					//System.out.println(this.proxZone.getEntities().get(i).getIdenEntityName());
			} 
          }
	   }
	 }
 	
 
 
 }
 
 public String getProxemicDIM(String entity,String axe) {
	 for (int i=0; i<this.proxZone.getEntities().size(); i++) 
	 {
	  if(entity==this.proxZone.getEntities().get(i).getIdenEntityName()) {
	  	  double ds=this.proxZone.getEntities().get(i).getRelOfDis().getDistance();
	  	  //String loc=			this.proxZone.getEntities().get(i).getRelOfLoc().getRelativeLocationOnScree();
	  	Boolean moAxi= false;
	  	  switch (axe) {
		 case "azimuth":moAxi=this.proxZone.getEntities().get(i).getRelOfDisMov().isAzimuthInRange();break;
		 case "pitch":moAxi=this.proxZone.getEntities().get(i).getRelOfDisMov().isPitchInRange();break;
		 case "roll":moAxi=this.proxZone.getEntities().get(i).getRelOfDisMov().isRollInRange();break;
		default:break;
	 }
	  	  String valueAx;
	  	  if(moAxi==true) valueAx="inTheRange ";else valueAx="outOfRange.";
	  	  //System.out.println(this.proxZone.setDistanceofEntity(ds));
	  	  return this.proxZone.setDistanceofEntity(ds)+"-"+ valueAx;
	 }
	 }
	 
	 return null;
 }
 /**
  * This method allows to assign the Proxemic Zone of a generic entity EG,
  * according to the distance D.
  * @param distance
  */
 public void setProxemicDistance(double distance) {
	this.zoneEg= this.proxZone.setDistanceofEntity(distance);
	 
 }
 /**
  * This method returns the Proxemic Zone of an generic  entity identifiable
  * @param entity name
  * @return
  */
 public String getProxemicZoneByDistance() {
	 return this.zoneEg;
 }
 private void setIniEnty(String entity, double distance) {
	 	 
		 Entity Ed0= new Entity(entity);
		 Distance d= new Distance();
		 Ed0.setRelOfDis(d);
		 Ed0.distance.setDistance(distance);
		 this.proxZone.setEntities(Ed0);
	 	 
	 }
 private void setIniEntyDILMO(String entity,double distance,float location) {
	 if(this.proxZone.getEntities().size()==0) { 
		 Entity Ed0= new Entity(entity);
		 Distance d= new Distance();
		 Location lo= new Location();
		 Ed0.setRelOfDis(d);
		 Ed0.distance.setDistance(distance);
		 Ed0.setRelOfLocation(lo);
		 Ed0.location.setRelativeLocationScreen(location);
		 this.proxZone.setEntities(Ed0);
 	 }
   }
 private void setDIM(String entity,double distance,String  axe,float max,float min,float value) {
	 if(this.proxZone.getEntities().size()==0) { 
		 Entity Ed0= new Entity(entity);
		 Distance d= new Distance();
		 Movement mo= new Movement();
		 Ed0.setRelOfDis(d);
		 Ed0.distance.setDistance(distance);
		 Ed0.setRelOfDisMov(mo);
		 switch (axe) {
			 case "azimuth":Ed0.movement.setAzimuthWithRange(max,min,value);break;
			 case "pitch":Ed0.movement.setPitchWithRange(max,min,value);break;
			 case "roll":Ed0.movement.setRollWithRange(max,min,value);break;
			default:break;
		 }
		this.proxZone.setEntities(Ed0);
 	 }
   }
 public static void main(String[] args) {
	 	
	 	//**Proxemic zone**
		ProxZone p = new ProxZone(0.5,1,4,50);
		Dilmo dilmo= new Dilmo(p);
       
		//**** test DI************
		dilmo.setProxemicDI("Paulo", 0.5);
	   dilmo.setProxemicDI("Paulo3", 2);
	    //dilmo.setProxemicDI("Paulo", 4);
	   System.out.println(dilmo.getProxemicDI("Paulo"));
	   System.out.println(dilmo.getProxemicDI("Paulo3"));
	  //**** test DIL************
	    dilmo.setProxemicDIL("Antonio", 3, 500);
	   System.out.println(dilmo.getProxemicDIL("Antonio"));
      //**** test DIM************	      
	 dilmo.setProxemicDIM("Fanny", 8, "azimuth", 8, 2, 9);
	 dilmo.setProxemicDIM("Fanny", 0.5, "azimuth", 8, 2, 9);
	 System.out.println(dilmo.getProxemicDIM("Fanny","azimuth"));    
	 // System.out.println(p.getEntities().size());
 
	 //**** test DIO***** aqui
	 //Based on android face  recognition
    Orientation orientation = new Orientation();
	String myTwoDimensionalStringArray[][] = new String[2][2];
	myTwoDimensionalStringArray[0][0] = "Id";
	myTwoDimensionalStringArray[0][1] = "100";
	myTwoDimensionalStringArray[1][0] = "id1";
	myTwoDimensionalStringArray[1][1] = "300";
	orientation.setDetectedFaces(myTwoDimensionalStringArray,p);
    orientation.isFaceDetected("id0","socialZone");
 
		
	}
	
}
