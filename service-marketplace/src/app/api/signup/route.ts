import { NextResponse } from "next/server";
import { prismaClient } from "@/lib/prisma";
import { hash } from "bcryptjs";
import { z } from "zod";

const signUpSchema = z.object({
  name: z.string().min(1),
  email: z.string().email(),
  password: z.string().min(6),
  role: z.enum(["CUSTOMER", "WORKER"]).default("CUSTOMER"),
});

export async function POST(request: Request) {
  try {
    const json = await request.json();
    const parsed = signUpSchema.safeParse(json);
    if (!parsed.success) {
      return NextResponse.json({ error: "Invalid input" }, { status: 400 });
    }
    const { name, email, password, role } = parsed.data;

    const existing = await prismaClient.user.findUnique({ where: { email } });
    if (existing) {
      return NextResponse.json({ error: "Email already in use" }, { status: 409 });
    }
    const passwordHash = await hash(password, 10);
    const user = await prismaClient.user.create({
      data: { name, email, passwordHash, role },
      select: { id: true, email: true, name: true, role: true },
    });
    return NextResponse.json({ user }, { status: 201 });
  } catch (error) {
    return NextResponse.json({ error: "Server error" }, { status: 500 });
  }
}

