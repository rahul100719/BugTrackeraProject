import { PrismaClient } from "@/generated/prisma";

declare global {
  // eslint-disable-next-line no-var
  var cachedPrismaClient: PrismaClient | undefined;
}

export const prismaClient: PrismaClient =
  global.cachedPrismaClient ?? new PrismaClient();

if (process.env.NODE_ENV !== "production") {
  global.cachedPrismaClient = prismaClient;
}

