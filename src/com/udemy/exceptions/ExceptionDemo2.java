package com.udemy.exceptions;

import java.io.IOException;

public class ExceptionDemo2 {
	private static void fileCopyWithARM() throws IOException {
		try (Test t = new Test(); Test2 t2 = new Test2()) {
			throw new IOException("Important Exception");
		}
	}

	private static void fileCopyWithoutARM() throws IOException {
		Test t = null;
		Test2 t2 = null;

		try {
			t = new Test();
			t2 = new Test2();
			throw new IOException("Important Exception");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (t2 != null) {
				t2.close();
			}

			if (t != null) {
				t.close();
			}

		}
	}

	private static void fileCopy2() {
		Test t = null;
		Test2 t2 = null;
		IOException ioException = null;
		try {
			t = new Test();
			t2 = new Test2();
			throw new IOException("Important Exception");
		} catch (IOException e) {
			ioException = e;
		} finally {
			if (ioException != null) {
				try {
					t2.close();
				} catch (IOException e) {
					ioException.addSuppressed(e);
				}

				try {
					t.close();
				} catch (IOException e) {
					ioException.addSuppressed(e);

				}
			} else {
				try {
					t2.close();
				} catch (IOException e) {
					ioException = e;
				}

				try {
					t.close();
				} catch (IOException e) {
					ioException.addSuppressed(e);

				}

			}
		}
	}

	public static void main(String[] args) {
		try {
			fileCopyWithoutARM();
		} catch (IOException e) {
			System.out.println("Exception thrown:" + e.getMessage());
//			Throwable throwables[] = e.getSuppressed();
//			System.out.println(throwables[0].getMessage());
//			System.out.println(throwables[1].getMessage());
		}

	}
}

class Test implements AutoCloseable {

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		throw new IOException("Trivial Exception");
	}

}

class Test2 implements AutoCloseable {

	@Override
	public void close() throws IOException {
		throw new IOException("Trivial Exception 2");

	}

}