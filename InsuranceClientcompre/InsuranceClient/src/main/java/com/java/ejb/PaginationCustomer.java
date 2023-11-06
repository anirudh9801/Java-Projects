package com.java.ejb;

import java.io.Serializable;
import java.util.List;
import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;

public class PaginationCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Customer> customerList;
    private CustomerDaoImpl customerImpl;

    // Pagination variables
    private int totalRows;
    static private int firstRow;
    private int rowsPerPage;
    private int totalPages;
    private int pageRange;
    private Integer[] pages;
    private int currentPage;

    public PaginationCustomer() {
        customerImpl = new CustomerDaoImpl();
        rowsPerPage = 5; // Default rows per page
        pageRange = 10; // Default page range
    }

    public List<Customer> getCustomerList() {
        if (customerList == null) {
            loadCustomers();
        }
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageRange() {
        return pageRange;
    }

    public void setPageRange(int pageRange) {
        this.pageRange = pageRange;
    }

    public Integer[] getPages() {
        return pages;
    }

    public void setPages(Integer[] pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    private void loadCustomers() {
        customerList = customerImpl.getCustomersWithPagination(firstRow, rowsPerPage);
        totalRows = customerImpl.countTotalCustomers();

        currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
        totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);

        int pagesLength = Math.min(pageRange, totalPages);
        pages = new Integer[pagesLength];

        int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);

        for (int i = 0; i < pagesLength; i++) {
            pages[i] = ++firstPage;
        }
    }

    public void pageFirst() {
        page(0);
    }

    public void pageNext() {
        page(firstRow + rowsPerPage);
    }

    public void pagePrevious() {
        page(firstRow - rowsPerPage);
    }

    public void pageLast() {
        page(totalRows - ((totalRows % rowsPerPage != 0) ? totalRows % rowsPerPage : rowsPerPage));
    }

    public void page(ActionEvent event) {
        page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);
    }

    private void page(int firstRow) {
        this.firstRow = firstRow;
        loadCustomers();
    }
}
