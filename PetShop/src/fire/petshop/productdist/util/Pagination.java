package fire.petshop.productdist.util;

public class Pagination {
	 static String lineBreak = System.getProperty("line.separator");
	    public Pagination() 
	    {
	    }

	    public static String getPageStr(String uri,int pageNow,int pageCount)
	    {
	        StringBuffer sb = new StringBuffer();
	        //sb.append("<TABLE border=\"1\" width=\"100%\">"+lineBreak);
	        sb.append("<TR>"+lineBreak);
	        //sb.append("<TD><a href=\""+uri+"?pageNow=1\">Top</a></TD>"+lineBreak);
	      if(pageNow<pageCount)
	        {
	            sb.append("<TD><a href=\"" + uri + "?pageNow=" + (pageNow + 1) +
	                      "\">More</a></TD>"+lineBreak);
	        }
//	            else
//	        {
//	            sb.append("<TD>Next</TD>"+lineBreak);
//	        }
	        if(pageNow>1)
	        {
	            sb.append("<TD><a href=\"" + uri + "?pageNow=" + (pageNow - 1) +
	                      "\">Previous</a></TD>"+lineBreak);
	        }
//else
//	        {
//	            sb.append("<TD>Before</TD>"+lineBreak);
//	        }
	        //sb.append("<TD><a href=\""+uri+"?pageNow="+pageCount+"\">End</a></TD>"+lineBreak);
	        //sb.append("<TD>"+pageNow+"/"+pageCount+"</TD>"+lineBreak);
	        //sb.append("</TR></TABLE>"+lineBreak);
	        return sb.toString();
	    }
}
