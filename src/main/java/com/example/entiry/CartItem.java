package com.example.entiry;


	public class CartItem {
		private Integer itemId; // 購物車明細 Id
		private Integer cartId; // 購物車 Id
		private double price;
		private Cart cart; // 購物車物件(關聯欄位)
		private Course course; // 商品物件(關聯欄位)
		
		public CartItem() {
			
		}
		
		public CartItem(Integer itemId, Integer cartId ) {
			this.itemId = itemId;
			this.cartId = cartId;

			
			// 根據 productId 找到 Product 物件
			// 根據 cartId 找到 Cart 物件
		}

		public Integer getItemId() {
			return itemId;
		}

		public void setItemId(Integer itemId) {
			this.itemId = itemId;
		}

		public Integer getCartId() {
			return cartId;
		}

		public void setCartId(Integer cartId) {
			this.cartId = cartId;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public Course getcourse() {
			return course;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		public void setProduct(Course course) {
			this.course = course;
		}

		@Override
		public String toString() {
			return "CartItem [itemId=" + itemId + ", cartId=" + cartId + ", price=" + price + ", cart=" + cart
					+ ", course=" + course + "]";
		}


		

	
		
		
}

