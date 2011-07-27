package egovframework.gettingstart.util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;

public class ImagePaginationRenderer extends AbstractPaginationRenderer {
	
    public ImagePaginationRenderer() {
	// TODO contextRoot 반영
	
    	firstPageLabel = "<a href=\"#\" onclick=\"{0}({1}); \"><img src=\"/start/images/icon/icon_prevend.gif\" border=0/></a>&#160;";
    	previousPageLabel = "<a href=\"#\" onclick=\"{0}({1}); \"><img src=\"/start/images/icon/icon_prev.gif\" border=0/></a>&#160;";
    	currentPageLabel = "<strong>{0}</strong>&#160;";
    	otherPageLabel = "<a href=\"#\" onclick=\"{0}({1}); \">{2}</a>&#160;";
    	nextPageLabel = "<a href=\"#\" onclick=\"{0}({1}); \"><img src=\"/start/images/icon/icon_next.gif\" border=0/></a>&#160;";
    	lastPageLabel = "<a href=\"#\" onclick=\"{0}({1}); \"><img src=\"/start/images/icon/icon_nextend.gif\" border=0/></a>&#160;";
    }
}
