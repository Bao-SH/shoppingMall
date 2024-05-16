import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ProductList = () => {
    const [products, setProducts] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [totalPages, setTotalPages] = useState(0);

    useEffect(() => {
        fetchProducts();
    }, [currentPage]);

    const fetchProducts = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/products?page=${currentPage}&size=15`);
            setProducts(response.data);
            // Assuming the backend API returns total number of products and pages
            setTotalPages(response.headers['x-total-pages']);
        } catch (error) {
            console.error('Error fetching products:', error);
        }
    };

    const handlePageChange = (page) => {
        setCurrentPage(page);
    };

    return (
        <div>
            {products.map(product => (
                <div key={product.id}>
                    <img src={product.imageUrl} alt={product.name} />
                    <p>{product.name}</p>
                    <p>Price: {product.price}</p>
                    <p>Stock: {product.stock}</p>
                </div>
            ))}
            <div>
                {Array.from({ length: totalPages }, (_, index) => (
                    <button key={index} onClick={() => handlePageChange(index + 1)}>
                        {index + 1}
                    </button>
                ))}
            </div>
        </div>
    );
};

export default ProductList;
