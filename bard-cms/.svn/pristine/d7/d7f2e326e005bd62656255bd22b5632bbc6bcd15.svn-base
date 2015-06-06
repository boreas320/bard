     package com.bard.davol.util;
     
     public class Pager
     {
       private int totalRows;
       private int pageSize = 5;
       private int currentPage;
       private int totalPages;
       private int startRow;
     
       public Pager()
       {
       }
     
       public Pager(int _totalRows)
       {
         this.totalRows = _totalRows;
         this.totalPages = (this.totalRows / this.pageSize);
         int mod = this.totalRows % this.pageSize;
         if (mod > 0) {
           this.totalPages += 1;
         }
         this.currentPage = 1;
         this.startRow = 0;
       }
       public void goPage(int page) {
         if (page < 1)
           setCurrentPage(1);
         else if (page > getTotalPages())
           setCurrentPage(getTotalPages());
         else {
           setCurrentPage(page);
         }
         this.startRow = ((this.currentPage - 1) * this.pageSize);
       }
     
       public void first()
       {
         this.currentPage = 1;
         this.startRow = 0;
       }
     
       public void previous() {
         if (this.currentPage == 1) {
           return;
         }
         this.currentPage -= 1;
         this.startRow = ((this.currentPage - 1) * this.pageSize);
       }
     
       public void next() {
         if (this.currentPage < this.totalPages) {
           this.currentPage += 1;
         }
         this.startRow = ((this.currentPage - 1) * this.pageSize);
       }
     
       public void last() {
         this.currentPage = this.totalPages;
         this.startRow = ((this.currentPage - 1) * this.pageSize);
       }
       public void refresh(int _currentPage) {
         this.currentPage = _currentPage;
         if (this.currentPage > this.totalPages)
           last();
       }
     
       public int getStartRow()
       {
         return this.startRow;
       }
       public int getTotalPages() {
         return this.totalPages;
       }
       public int getCurrentPage() {
         return this.currentPage;
       }
       public int getPageSize() {
         return this.pageSize;
       }
       public void setTotalRows(int totalRows) {
         this.totalRows = totalRows;
       }
       public void setStartRow(int startRow) {
         this.startRow = startRow;
       }
       public void setTotalPages(int totalPages) {
         this.totalPages = totalPages;
       }
       public void setCurrentPage(int currentPage) {
         this.currentPage = currentPage;
       }
       public void setPageSize(int pageSize) {
         this.pageSize = pageSize;
       }
       public int getTotalRows() {
         return this.totalRows;
       }
     }

    