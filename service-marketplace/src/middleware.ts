import { auth } from "@/lib/auth";
import { NextResponse } from "next/server";

export default auth(() => {
	return NextResponse.next();
});

export const config = {
	matcher: [
		"/dashboard/:path*",
		"/api/bookings/:path*",
		"/api/worker/:path*",
	],
};

