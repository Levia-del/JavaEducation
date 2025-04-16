package Run;

public class FlowCost {
   public int cf;
   public int mf;
   
   public FlowCost(int mf)
   {
	   this.mf = mf;
   }
	
   public void setCF(int cf)
   {
	   this.cf = cf;
   }
   
   public int maxFill()
   {
	   return mf-cf;
   }
   
   public boolean isFilled()
   {
	   return !(cf<mf);
   }
   
   public String toString()
   {
	   return cf+"/"+mf;
   }
}
