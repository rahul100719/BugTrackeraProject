Service Marketplace app scaffold: worker self-registration, customer booking, location distance, and payments-ready.

## Getting Started

## Getting Started

1. Copy environment variables

```
cp .env.example .env
```

2. Install dependencies

```
npm install
```

3. Setup database

```
npx prisma migrate dev
```

4. Run the dev server

```
npm run dev
```

Open `http://localhost:3000`.

### Auth
- Credentials sign in via `/api/auth/signin` (NextAuth) and sign-up via `POST /api/signup`.
- Roles: `CUSTOMER` and `WORKER` on `User`.

### Next steps
- Worker onboarding UI to create `WorkerProfile` and `ServiceOffering` with geolocation.
- Customer search page listing nearby workers; compute distance server-side.
- Booking flow with status updates.
- Stripe Connect platform payments with application fee.
